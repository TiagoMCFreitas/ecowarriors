package com.ecowarriors.ferramentas;

import io.github.cdimascio.dotenv.Dotenv;


public class ConexaoBDEnv {

    Dotenv dotenv = Dotenv.configure().load();

    // Obtém as variáveis do ambiente
    String dbUrl = dotenv.get("jdbc:postgresql://localhost:5433/'nomeDoBanco'");
    String dbUser = dotenv.get("postgres");
    String dbPassword = dotenv.get("postgres");}

