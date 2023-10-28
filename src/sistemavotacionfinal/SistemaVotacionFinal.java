/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemavotacionfinal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author Carina H
 */
public class SistemaVotacionFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
        String Usuario = "Admin";
        String Contraseña = "102023";
        File Usuariolistado = new File ("Archivo.txt"); 
        List<Usuario> usuarios = new ArrayList<>();

        boolean salir = false;
        while (!salir) {
            System.out.println("Bienvenido al Sistema de Votacion");
            System.out.println("A qué campo deseas ingresar");
            System.out.println("1. Administrador");
            System.out.println("2. Registro de usuario");
            System.out.println("3. Registrador de votante");
            System.out.println("4. Votante");
            System.out.println("5. Auditor");
            System.out.println("6. Salir");
            System.out.print("Por favor ingrese una opcion: ");
            int opcion = scan.nextInt();
            scan.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Bienvenido Administrador");
                    System.out.println("Ingrese su contraseña");
                    System.out.println("Usuario: Admin");
                    System.out.println("Contrasena: ");
                    Contraseña = scan.next();
                    if (Usuario.equals("Admin") && Contraseña.equals("102023")) {
                        System.out.println("Bienvenido al Sistema \n");
                    } else {
                        System.out.println("La contraseña es incorrecta");
                       
                    }
                    break;
                    
                case 2:
                    System.out.println("Registro de Usuario");
                    while (true) {
                        System.out.println("Menu de opciones:");
                        System.out.println("1. Crear usuario");
                        System.out.println("2. Editar usuario");
                        System.out.println("3. Deshabilitar usuario"); 
                        System.out.println("4. Reiniciar contraseña");
                        System.out.println("5. Salir");
                        System.out.print("Seleccione una opción: ");
                        opcion = scan.nextInt();
                        scan.nextLine(); // Consumir la nueva línea

                        switch (opcion) {
                            case 1:
                                System.out.println("Creacion de usuario:");
                                Usuario nuevoUsuario = crearUsuario();
                                usuarios.add(nuevoUsuario);
                                System.out.println("Usuario creado con exito.");
                                break;
                            case 2:
                                System.out.println("Editar usuario:");
                                editarUsuario(usuarios);
                                break;
                            case 3:
                                System.out.println("Deshabilitar usuario:");
                                deshabilitarUsuario(usuarios);
                                break;
                            case 4:
                                System.out.println("Reiniciar contraseña:");
                                reiniciarContraseña(usuarios);
                                break;
                            case 5:
                                System.out.println("Saliendo del registro de usuarios.");
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                        }
                        if (opcion == 5) {
                            break;
                        }
                    }
                    break;
                case 3: 
                    System.out.println("Registro de Votante");
                    System.out.println("1. Agregar votante: ");
                    System.out.println("2. Modificar votante: ");
                    System.out.println("3. Reiniciar contrasena votante: ");
                    System.out.println("4. Registrar fallecimieto de votante: ");
                    System.out.println("Por favor ingrese una opcion; \n ");  
                    opcion = scan.nextInt(); 
                    switch (opcion) {
                        case 1: 
                    scan.nextLine(); 
                    System.out.print("Ingrese primer y segundo nombre:");
                    String nombreVotante = scan.nextLine(); 
                    System.out.print("Ingrese primer y segundo apellido: ");
                    String apellidoVotante = scan.nextLine(); 
                    System.out.print("Ingrese el número de identificación del votante: ");
                    String idVotante = scan.nextLine(); 
                     System.out.print("Ingrese M si es Masculino o F si es Femenino: ");
                    String genero = scan.next();
                    scan.nextLine(); 
                    System.out.print("Ingrese fecha de nacimiento: ");
                    String nacimiento = scan.nextLine(); 
                    System.out.print("Ingrese pais de residencia: ");
                    String pais = scan.nextLine(); 
                    System.out.print("Ingrese departamento de residencia: ");
                    String departamento = scan.nextLine(); 
                    System.out.print("Ingrese municipio de residencia: ");
                    String municipio = scan.nextLine(); 
                    System.out.print("Ingrese direccion de residencia: ");
                    String direccion = scan.nextLine(); 
                    //Para verificar si el votante es mayor de edad 
                    SimpleDateFormat fecha = new SimpleDateFormat ("dd/MM/yyyy"); 
                    Date fechanacimiento;
                    
                    try {
                        // convertir la fecha de nacimiento 
                   fechanacimiento = fecha.parse(nacimiento);
                  //esta funcion es para obtener la fecha actual
                    Date fechaActual = new Date();
                    //Aqui se puede calcular la diferencia entre la fecha actual y la fecha de nacimiento
                    long diferenciaMillis = fechaActual.getTime() - fechanacimiento.getTime();
                    // calcular la edad en años 
                    int edad = (int) (diferenciaMillis/31536000000L); // Un año en milisegundos  años
                    //Verificar si la persona es mayor de 18 años y si es asi   que le aparezca un mensaje 
                    if (edad >= 18){
                        System.out.println("El votante es mayor de edad puede votar:\n ");
                    }else{
                        System.out.println("El votante es menor de edad no puede :\n ");
                    }     
                        
                   } catch (ParseException ex) {
            }  
                    break; 
                        case 2: 
                         // Modificar votante  
                        scan.nextLine(); 
                        System.out.print("Ingrese el número de identificación del votante a modificar: ");
                            String idVotanteModificar = scan.nextLine();
   
                         // para modificar la dirección:
                        System.out.print("Ingrese el nuevo país de residencia: ");
                        String nuevoPais = scan.nextLine();
                        if (!nuevoPais.isEmpty()) {
                       
                        }
                        // Se modificara el departamento 
                         System.out.print("Por favor ingrese el nuevo departamento de residencia: ");
                         String nuevoDepartamento = scan.nextLine();
                         if (!nuevoDepartamento.isEmpty()) {
                       
                            }
                        // Modificar el municipio 
                          System.out.print("Por favor ingrese el nuevo municipio de residencia (deje en blanco para no cambiar): ");
                          String nuevoMunicipio = scan.nextLine();
                           if (!nuevoMunicipio.isEmpty()) {
                           
                            }
                        // Modificar la dirección 
                         System.out.print("Por favor ingrese la nueva dirección de residencia : ");
                        String nuevaDireccion = scan.nextLine();
                        if (!nuevaDireccion.isEmpty()) {
                    
                       }
                     // Modificar el correo electrónico 
                      System.out.print("Por favor ingrese el nuevo correo electrónico: ");
                    String nuevoCorreo = scan.nextLine();
                    if (!nuevoCorreo.isEmpty()) {
                  
                     }
                          

                    System.out.println("La información del votante esta vactualizada.");
                      break;

                    case 3: // Reiniciar contraseña del votante
                        scan.nextLine(); 
                        System.out.print("Por favor ingrese el número de identificación del votante para reiniciar la contraseña: ");
                        String idVotanteReiniciar = scan.nextLine();

                        // Para genera una nueva contraseña 
                        String nuevaContraseña = generarNuevaContraseña();
    
                         // Almacena la nueva contraseña 
                        System.out.println("Contraseña reiniciada con éxito.");
                        break;

                    case 4: // Registrar fallecimiento del votante 
                     scan.nextLine(); // Limpia el buffer
                     System.out.print("Por favor ingrese el número de identificación del votante para registrar su fallecimiento: ");
                    String idVotanteFallecido = scan.nextLine();
    
                    // Identidicar al votante como fallecido

                      System.out.println("El votante ha sido registrado como fallecido.");
                        break;

                    default:
                    System.out.println("La opción no es válida.");
          
                    }
                    break; 
                    
                case 4: 
                     System.out.println("Votante");
                     System.out.print("Ingrese su número de identificación: ");
                     String idVotante = scan.next();
                    
               
                    boolean encontrado = false;
                    
                    break; 
                case 5: break; 
                    
                case 6:
                    System.out.println("Saliendo del programa.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            
            
        }
    }

    static Usuario crearUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre completo: ");
        String nombres = scanner.nextLine();
        System.out.print("ingrese sus apellidos completos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese Correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();
        return new Usuario(nombres, apellidos, correo, contraseña, true);
        
       // try {
         //  String Usuariolistado = "";
           // FileWriter ArchivarUsuario = new FileWriter(Usuariolistado);
            //BufferedWriter Escribir = new BufferedWriter(ArchivarUsuario);
            //String datoss = (nombres + "|"  + apellidos + "|" + correo + "|" + contraseña + "\n"); 
            //Escribir.write(datoss + "\n");
            //Escribir.close();
            //ArchivarUsuario.close();
            
                        
            // } catch (IOException ex) {
    
    //}
    }
             

    static void editarUsuario(List<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el correo electrónico del usuario que desea editar: ");
        String correo = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                System.out.print("Ingrese nuevos nombres: ");
                usuario.setNombres(scanner.nextLine());
                System.out.print("Ingrese nuevos apellidos: ");
                usuario.setApellidos(scanner.nextLine());
                System.out.println("Usuario editado con éxito.");
                return;
                
                
                
            }
        }

        System.out.println("Usuario no encontrado.");
    }

    static void deshabilitarUsuario(List<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el correo electrónico del usuario que desea deshabilitar: ");
        String correo = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                usuario.setActivo(false);
                System.out.println("Usuario deshabilitado con éxito.");
                return;
            }
        }

        System.out.println("Usuario no encontrado.");
    }

    static void reiniciarContraseña(List<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el correo electrónico del usuario cuya contraseña desea reiniciar: ");
        String correo = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                System.out.print("Ingrese nueva contraseña: ");
                usuario.setContraseña(scanner.nextLine());
                System.out.println("La contraseña fue reiniciada con éxito.");
                return;
            }
        }

        System.out.println("Usuario no encontrado.");
    }

    private static String generarNuevaContraseña() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

class Usuario {
    private String nombres;
    private String apellidos;
    private String correo;
    private String contraseña;
    private boolean activo;

    public Usuario(String nombres, String apellidos, String correo, String contraseña, boolean activo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contraseña = contraseña;
        this.activo = activo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

        
        



    
    

