/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *  Clase que guardara el nombre y los roles de los usuarios.
 * @author Ramon Lopez
 */
public class Usuarios {
    //2 = nombre    3 = rolsuper    4 = rolinherit
    //5 = rolcreaterole     6 = rolcreatedb     8 rolreplication
    private String name;
    private boolean rolSuper;
    private boolean rolInherit;
    private boolean rolCreateRole;
    private boolean rolCreateDB;
    private boolean rolReplication;
    
    
    public Usuarios(String nombre, boolean rolSuper, boolean rolInherit, boolean rolCreateRole,
            boolean rolCreateDB, boolean rolReplication){
        this.name = name;
        this.rolSuper = rolSuper;
        this.rolCreateDB = rolCreateDB;
        this.rolInherit = rolInherit;
        this.rolCreateRole = rolCreateRole;
        this.rolReplication = rolReplication;
    }

    //getters
    public String getName() {
        return name;
    }

    public boolean isRolSuper() {
        return rolSuper;
    }

    public boolean isRolInherit() {
        return rolInherit;
    }

    public boolean isRolCreateRole() {
        return rolCreateRole;
    }

    public boolean isRolCreateDB() {
        return rolCreateDB;
    }

    public boolean isRolReplication() {
        return rolReplication;
    }
    
    
}
