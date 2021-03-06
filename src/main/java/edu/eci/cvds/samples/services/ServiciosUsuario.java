package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;

import java.util.List;

public interface ServiciosUsuario {


    /**
     * Permite consultar a un usuario dado su correo
     * @param email correo del usuario que se desea consultar
     * @return Usuario cuyo correo sea el ingresado
     * @throws ExcepcionServiciosBancoProyectos
     */
    public abstract Usuario consultarUsuario(String email) throws ExcepcionServiciosBancoProyectos;

    /**
     * Permite consultar a todos los usuarios
     * @return Lista con los usuarios del sistema
     * @throws ExcepcionServiciosBancoProyectos
     */
    public abstract List<Usuario> consultarUsuarios() throws ExcepcionServiciosBancoProyectos;

    /**
     * Permite registrar a un usuario
     * @param u Usuario que se va a registrar
     * @throws ExcepcionServiciosBancoProyectos
     */

    public abstract void registrarUsuario(Usuario u) throws ExcepcionServiciosBancoProyectos;

    /**
     * Permite asignar un rol a un usuario
     * @param usuario Usuario al que se le va a asignar al rol
     * @param rol que se va a asignar al usuario
     * @throws ExcepcionServiciosBancoProyectos
     */

    public abstract void asignarRolUsuario(String rol , Usuario usuario) throws ExcepcionServiciosBancoProyectos;


}
