package com.ecowarriros.ferramentas;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBDEnv {

    Dotenv dotenv = Dotenv.configure().load();

    // Obtém as variáveis do ambiente
    String dbUrl = dotenv.get("jdbc:postgresql://localhost:5433/'nomeDoBanco'");
    String dbUser = dotenv.get("postgres");
    String dbPassword = dotenv.get("postgres");}

