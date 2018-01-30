package com.learncamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static java.lang.System.lineSeparator;

public class CamelFileSampleProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange)throws Exception{
        System.out.println("Exchange recieved is ::"+exchange.getIn().getBody());
        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();

        String readLine=null;
        String newValue="";

        if(file!=null){
            FileReader incomingFileReader = new FileReader(file.getFile());
            BufferedReader icFileBufferedReader = new BufferedReader(incomingFileReader);

            while((readLine = icFileBufferedReader.readLine()) != null){
                System.out.println("Incoming Line is :: "+ readLine);

                String oldValue = readLine;
                newValue = newValue.concat(oldValue.replace(",",":"))+ lineSeparator();
                exchange.getIn().setBody(newValue);

            }
        }



    }
}
