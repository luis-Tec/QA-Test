package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Paises {
    WebDriver driver;

    //Botones Paises

    //America Central
    //Boton Costa Rica
    By botonCR = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[1]");
    //Boton El Salvador
    By botonSL = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[2]");
    //Boton Guatemala
    By botonGT = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[3]");
    //Boton Honduras
    By botonHN = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[4]");
    //Boton Nicaragua
    By botonNC = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[5]");
    //Boton Panama
    By botonPN = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[6]");

    //Caribe
    //Boton Aruba
    By botonAR = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[1]");
    //Boton Barbados
    By botonBA = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[2]");
    //Boton Republica Dominicana
    By botonRP = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[3]");
    //Boton Jamaica
    By botonJA = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[4]");
    //Boton Trinidad y Tobago
    By botonTB = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[5]");
    //Boton Islas Virgenes, US
    By botonIV = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[6]");

    //Sur America
    //Boton Colombia
    By botonCL = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[5]/div/ul/li");

    //Boton Idiomas
    By botonIdiomas = By.xpath("//*[@id=\"dropdownMenu1\"]");
    //Boton Ingles
    By botonIdiomaEN = By.xpath("/html/body/section/section/section[1]/div/div[1]/div/li/div/ul/li[1]/a");
    //Boton Español
    By botonIdiomaES = By.xpath("/html/body/section/section/section[1]/div/div[1]/div/li/div/ul/li[2]/a");

    public Paises(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBotonPais(String pais) {
        if (pais.equals("Costa Rica")) {
            driver.findElement(botonCR).click();
        } else if (pais.equals("El Salvador")) {
            driver.findElement(botonSL).click();
        } else if (pais.equals("Guatemala")) {
            driver.findElement(botonGT).click();
        } else if (pais.equals("Honduras")) {
            driver.findElement(botonHN).click();
        } else if (pais.equals("Nicaragua")) {
            driver.findElement(botonNC).click();
        } else if (pais.equals("Panamá")) {
            driver.findElement(botonPN).click();
        } else if (pais.equals("Aruba")) {
            driver.findElement(botonAR).click();
        } else if (pais.equals("Barbados")) {
            driver.findElement(botonBA).click();
        } else if (pais.equals("República Dominicana")) {
            driver.findElement(botonRP).click();
        } else if (pais.equals("Jamaica")) {
            driver.findElement(botonJA).click();
        } else if (pais.equals("Trinidad y Tobago")) {
            driver.findElement(botonTB).click();
        } else if (pais.equals("Islas Vírgenes, US")) {
            driver.findElement(botonIV).click();
        } else if (pais.equals("Colombia")) {
            driver.findElement(botonCL).click();
        }
    }

    public void clickBotonIdioma(String idioma) {
        driver.findElement(botonIdiomas).click();
        if (idioma.equals("es")) {
            driver.findElement(botonIdiomaES).click();
        } else if (idioma.equals("en")) {
            driver.findElement(botonIdiomaEN).click();
        }
    }
}
