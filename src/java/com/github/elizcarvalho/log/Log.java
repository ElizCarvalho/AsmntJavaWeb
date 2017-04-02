/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Eliz
 */
public class Log {
    
    private String date(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatDate = new SimpleDateFormat("E, d MMM yyyy HH:mm");
        return formatDate.format(date);
    }
    
    
    public void gravarLog(StackTraceElement[] mensagem){
        
        String fileLog = "C:\\Users\\Eliz\\Documents\\NetBeansProjects\\AsmntJavaWeb\\src\\java\\com\\github\\elizcarvalho\\log.txt";
        
        try {
            FileWriter fw = new FileWriter(fileLog, true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.newLine();
                bw.write("["+date()+"]"+ Arrays.toString(mensagem));
                bw.flush();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
        public void gravarLog(String mensagem){
        
        String fileLog = "C:\\Users\\Eliz\\Documents\\NetBeansProjects\\AsmntJavaWeb\\src\\java\\com\\github\\elizcarvalho\\log\\log.txt";
        
        try {
            FileWriter fw = new FileWriter(fileLog, true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.newLine();
                bw.write("["+date()+"]"+ mensagem);
                bw.flush();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
