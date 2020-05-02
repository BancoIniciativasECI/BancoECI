package edu.eci.cvds.security;

import edu.eci.cvds.samples.services.ExcepcionServiciosBancoProyectos;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.faces.context.FacesContext;

public class ShiroLogger implements Logger {

    @Override
    public void login(String correo, String password, boolean rememberMe) throws ExcepcionServiciosBancoProyectos {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(correo, password, rememberMe);
            subject.getSession().setAttribute("Correo", correo);
            subject.login(token);
        } catch (UnknownAccountException uae) {
            throw new ExcepcionServiciosBancoProyectos("El usuario no está registrado", uae);
        } catch (IncorrectCredentialsException ice) {
            throw new ExcepcionServiciosBancoProyectos("Contraseña incorrecta", ice);
        }
    }

    @Override
    public boolean isAdmin() {
        return SecurityUtils.getSubject().hasRole("Administrador");
    }

    @Override
    public boolean isProponente() {
        return SecurityUtils.getSubject().hasRole("Proponente");
    }

    @Override
    public boolean isPMO() {
        return SecurityUtils.getSubject().hasRole("PMO");
    }

    @Override
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }
}
