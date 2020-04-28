package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Comentario;
import edu.eci.cvds.samples.entities.Iniciativa;

import java.util.Date;
import java.util.List;

public interface ServiciosIniciativa {

    /**
     * Metodo que permite consular los comentarios por iniciativa
     * @param idIniciativa id de la iniciativa de la cual se quieren conocer los comentarios
     * @return Lista de comentarios
     */
    public List<Comentario> consultarComentariosPorIniciativa(int idIniciativa) throws ExcepcionServiciosBancoProyectos ;

    /**
     * Metodo que permite registrar un comentario a una iniciativa
     * @param comentario comentario a registrar a la iniciativa
     * @param idIniciativa id de la iniciativa sobre la cual se realiza el comentario
     */
    public void agregarComentarioAIniciativa(Comentario comentario , int idIniciativa) throws ExcepcionServiciosBancoProyectos ;

    /**
     * Metodo que permite consultar las iniciativas ordenadas por una columna
     * @param columna Columna por la cual se quieren ordenar las iniciativas
     * @return Lista de iniciativas
     */
    public List<Iniciativa> consultarIniciativasOrdenadasPorColumna(String columna)throws ExcepcionServiciosBancoProyectos;

    /**
     * Metodo que permite consultar iniciativas que contengan una de ciertas palabras clave
     * @param palabras palabras clave que deben contener las iniciativas
     * @return Lista de iniciativas
     */
    public List<Iniciativa> consultarIniciativasPorPalabrasClaves(List<String> palabras) throws ExcepcionServiciosBancoProyectos;

    /**
     * Permite insertar una iniciativa
     * @param iniciativa Iniciativa a insertar
     * @param palabras palabras clave de la iniciativa
     * @throws ExcepcionServiciosBancoProyectos
     * @throws PersistenceException
     */

    public void  insertarIniciativa(Iniciativa iniciativa , List<String> palabras) throws ExcepcionServiciosBancoProyectos, PersistenceException;
    /**
     * Permite agregar palabras clave a una iniciativa
     * @param iniciativa Iniciativa a la cual se le van a asignar las palabras clave
     * @param palabras palabras clave de la iniciativa
     * @throws ExcepcionServiciosBancoProyectos
     * @throws PersistenceException
     */
    public void agregarPalabrasClaveAIniciativa(Iniciativa iniciativa , List<String> palabras) throws ExcepcionServiciosBancoProyectos;

    /**
     * Permite consultar todas las iniciativas
     * @return Lista con las iniciativas del sistema
     * @throws ExcepcionServiciosBancoProyectos
     */
    public abstract List<Iniciativa> consultarIniciativas() throws ExcepcionServiciosBancoProyectos;

    /**
     * Permite consultar una iniciativa por su id
     * @param  id id de la iniciativa a consultar
     * @return Iniciativa que coincida con el id ingresado como parametro
     * @throws ExcepcionServiciosBancoProyectos
     */
    public abstract Iniciativa consultarIniciativasPorId(int id) throws ExcepcionServiciosBancoProyectos;

    /**
     * Permite cambiar el estado de una iniciativa
     * @param  estado de la iniciativa a asignar
     * @param  iniciativa a la cual se le va asignar el nuevo estado
     * @throws ExcepcionServiciosBancoProyectos
     */
    public abstract void cambiarEstadoAiniciativa(String estado, Iniciativa iniciativa) throws  ExcepcionServiciosBancoProyectos;

    /**
     * Permite conocer el numero de iniciativas que tiene un area
     * @param area Finanzas, Proyectos, Ventas, Innovacion
     * @return Numero de iniciativas del area
     * @throws ExcepcionServiciosBancoProyectos
     */
    public abstract int consultarNumeroDeIniciativasPorArea(String area) throws ExcepcionServiciosBancoProyectos;

    /**
     * Permite conocer las iniciativas de un area
     * @param area finanzas, ventas, proyectos, innovacion
     * @return iniciativas del area
     * @throws ExcepcionServiciosBancoProyectos
     */
    public abstract List<Iniciativa> consultarIniciativasPorArea(String area) throws ExcepcionServiciosBancoProyectos;

    /**
     * Permite relacionar una iniciativa a otra
     * @param idIni id de iniciativa A
     * @param idIniRelacionada id de iniciativa B
     * @throws ExcepcionServiciosBancoProyectos
     */
    public abstract void agregarIniciativaRelacionadaAIniciativa(int idIni, int idIniRelacionada) throws  ExcepcionServiciosBancoProyectos;


}
