/*
 * Codigo obtenido de https://github.com/jgilsonsi/backup-postgresql/blob/master/src/main/java/com/jjdev/backup/postgresql/JBackupController.java
 * Modificado y adaptado por Ramon Lopez
 */
package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author jgilson
 */
public class JBackupController {

    private String USER;
    private int nivelCOmpresion;
    public JBackupController() {
    }

    public void executeCommand(String databaseName, String databasePassword, String type,String direccion,String USER,int nivelCompresion) {
        this.USER = USER;
        this.nivelCOmpresion = nivelCompresion;
        
        //Damos el directorio en el cual se guardara nuestro archivo
        File backupFilePath = new File(direccion/*System.getProperty("user.home")*/
                + File.separator + "backup_" + databaseName);

        //preguntamos si existe
        if (!backupFilePath.exists()) {
            File dir = backupFilePath;
            dir.mkdirs();
        }

        //declaramos un formato y creamos el nombre del archivo
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy"); //yyyyMMdd
        Calendar calendario = new GregorianCalendar();
        int hora, minutos,segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);                            //obtenemos la hora del sistema
        minutos = calendario.get(Calendar.MINUTE);                              //obtenemos los minutos del sistema
        segundos = calendario.get(Calendar.SECOND);                             //obtenemos los segundos del sistema
        String Tiempo = String.valueOf(hora) + "-" + String.valueOf(minutos) + "-" + String.valueOf(segundos);  //unimos todos los valores juntos en una variable
        String backupFileName = "backup_" + databaseName + "_" + sdf.format(new Date()) + "_" + Tiempo +  ".sql";//declaramos el nombre de nuestro archivo

        //creamos los comandos
        List<String> commands = getPgComands(databaseName, backupFilePath, backupFileName, type);
        
        //si los comandos estan vacios
        if (!commands.isEmpty()) {
            try {
                ProcessBuilder pb = new ProcessBuilder(commands);               //metemos los comandos al proceso
                pb.environment().put("PGPASSWORD", databasePassword);           //agregamos la contraseña como segundo comando

                Process process = pb.start();                                   //iniciamos el proceso

                //hacemos la lectura y mandamos en consola las acciones que se estan realizando
                try (BufferedReader buf = new BufferedReader(
                        new InputStreamReader(process.getErrorStream()))) {
                    String line = buf.readLine();
                    while (line != null) {
                        System.err.println(line);
                        line = buf.readLine();
                    }
                }

                //esperamos que termine el proceso y luego lo eliminamos
                process.waitFor();
                process.destroy();

                System.out.println("===> Success on " + type + " process.");
            } catch (IOException | InterruptedException ex) {
                System.out.println("Exception: " + ex);
            }
            
            
            //hacemos la compresion
            List<String> comandoCompresion = new ArrayList<>();
            
            comandoCompresion.add("powershell.exe");
            comandoCompresion.add("Compress-Archive");
            comandoCompresion.add("-Path");
            comandoCompresion.add(backupFilePath.getAbsolutePath()+ File.separator + backupFileName);
            comandoCompresion.add("-DestinationPath");
            comandoCompresion.add(backupFilePath.getAbsolutePath()+ File.separator + backupFileName+".zip");
            
            
            ProcessBuilder compresion = new ProcessBuilder(comandoCompresion);
            
            try{
                Process proceso = compresion.start();
                try (BufferedReader buf = new BufferedReader(
                        new InputStreamReader(proceso.getErrorStream()))) {
                    String line = buf.readLine();
                    while (line != null) {
                        System.err.println(line);
                        line = buf.readLine();
                    }
                }
                
                proceso.waitFor();
                proceso.destroy();
            } catch (IOException | InterruptedException ex) {
                System.out.println("Exception: " + ex);
            }
        } else {
            System.out.println("Error: Invalid params.");
        }
    }

    private List<String> getPgComands(String databaseName, File backupFilePath, String backupFileName, String type) {

        ArrayList<String> commands = new ArrayList<>();
        switch (type) {
            case "backup":
                commands.add("C:\\Program Files\\PostgreSQL\\13\\bin\\pg_dump.exe");
                commands.add("-h"); //database server host
                commands.add("localhost");
                commands.add("-p"); //database server port number
                commands.add("5432");
                commands.add("-U"); //connect as specified database user
                commands.add(USER);
                commands.add("-F"); //output file format (custom, directory, tar, plain text (default))
                commands.add("c");
                if (this.nivelCOmpresion!=0) {
                    commands.add("-Z"); //compresion del archivo
                    String nivel = String.valueOf(nivelCOmpresion);
                    commands.add(nivel);  //nivel de compresion
                }
                commands.add("-b"); //include large objects in dump
                commands.add("-v"); //verbose mode
                commands.add("-f"); //output file or directory name
                commands.add(backupFilePath.getAbsolutePath() + File.separator + backupFileName);
                commands.add("-d"); //database name
                commands.add(databaseName);
                
                break;
            case "restore":
                commands.add("pg_restore");
                commands.add("-h");
                commands.add("localhost");
                commands.add("-p");
                commands.add("5432");
                commands.add("-U");
                commands.add("postgres");
                commands.add("-d");
                commands.add(databaseName);
                commands.add("-v");
                commands.add(backupFilePath.getAbsolutePath() + File.separator + backupFileName);
                break;
            default:
                return Collections.EMPTY_LIST;
        }
        return commands;
    }

}
