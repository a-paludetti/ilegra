package br.com.desafio.ilegra.api.factories;

import br.com.desafio.ilegra.dao.ClientDao;
import br.com.desafio.ilegra.dao.SalesmanDao;
import br.com.desafio.ilegra.model.Batch;
import br.com.desafio.ilegra.model.Salesman;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

@Log4j2
public class FileProcessor {

    public static int SALESMAN_DATA = 0;
    public static int CLIENT_DATA = 1;
    public static int SALES_DATA = 2;
    private Batch batch = new Batch();

    @Autowired
    private SalesmanDao salesmanDao;

    @Autowired
    private ClientDao clientDao;

    public void process(File file) {
        try {
            int clients = 0;
            int salesman = 0;

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                int type;

                if (data.startsWith("001")) {
                    type = SALESMAN_DATA;
                } else if (data.startsWith("002")) {
                    type = CLIENT_DATA;
                } else {
                    type = SALES_DATA;
                }

                switch (type) {
                    case 0:
                        salesman++;
                        processSalesman(data);
                        break;
                    case 1:
                        clients++;
                        processClient(data);
                        break;
                    case 2:
                        processSalesData(data);
                        break;
                    default:
                        break;
                }
            }

            processBatch(salesman, clients);

            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }

    private void processBatch(int salesman, int clients) {
    }

    private void processSalesData(String data) {
    }

    private void processClient(String data) {
    }

    private void processSalesman(String data) {
        String[] brokenData = data.split("ç");
        Salesman salesman = new Salesman();
        salesman.setCpf(brokenData[1]);
        salesman.setName(brokenData[2]);
        salesman.setSalary(new BigDecimal(brokenData[3]));

        salesmanDao.save(salesman);
    }
}