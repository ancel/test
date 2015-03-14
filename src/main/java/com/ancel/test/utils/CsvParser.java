package com.ancel.test.utils;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

/**
 * 解析csv文件
 * @author Administrator
 *
 */
public class CsvParser implements Iterator<List<String>>{
 
    private static final Logger logger = LoggerFactory.getLogger(CsvParser.class);
 
    private CsvListReader reader = null;
    private List<String> row = null;
 
    public CsvParser(String csvFile, String encoding) {
        super();
        try {
            reader = new CsvListReader(new InputStreamReader(new FileInputStream(csvFile), encoding), CsvPreference.EXCEL_PREFERENCE);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
    }
 
    public boolean hasNext(){
        try {
            if(reader.getLineNumber() == 0){//
                row = reader.read();
            }
            row = reader.read();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return row != null;
    }
 
    public List<String> next(){
        return row;
    }
 
    public void remove(){
        throw new UnsupportedOperationException("本CSV解析器是只读的.");
    }
 
    public void close(){
        if(reader != null){
            try {
                reader.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
 
    /**
     * 当前行号,从1开始
     * @return int
     */
    public int getLineNumber(){
        return reader.getLineNumber() - 1;
    }
 
    public static void main(String[] args) {
        String file = "E:\\alibaba_companies_2013_half.gbk.csv";
 
        CsvParser p = new CsvParser(file, "GBK");
        int i = 0;
        while(p.hasNext()){
            List<String> row = p.next();
            System.out.println(p.getLineNumber() + " : " + row.get(0) + ", " + row.get(1));
            i++;
            if(i>200){
                break;
            }
        }
        p.close();
    }
 
}