package com.nttdata.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * Clase de configuración
 * 
 * @author Diego Lopez Strickland
 *
 */

public class NTTDataHibernateUtil {

	/** Factoria de sesion */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Generacion de factoria de sesiones
	 */
	static {

		try {

			// Generacion de la configuracion
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Throwable ex) {

			// Error de inicializacion
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Retorna la factoria de sesiones
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
