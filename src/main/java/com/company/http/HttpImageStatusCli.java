package com.company.http;

import java.util.Scanner;

public class HttpImageStatusCli {
    public static void main(String[] args) {
        try {
            new HttpImageStatusCli().askStatus();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public void askStatus() throws Exception {
        System.out.println("Please, enter HTTP status code");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String statusCode = scanner.next();

            if(statusCode.matches("[^\\d]+")) {
                System.out.println("Please enter valid number\n");
                System.out.println("Please, enter HTTP status code");
                continue;
            }

            new HttpStatusImageDownloader().downloadStatusImage(Integer.parseInt(statusCode));

            Thread.sleep(100);
            System.out.println("Do you want to continue? (yes or no)");
            if (scanner.next().equalsIgnoreCase("yes")) {
                System.out.println("Please, enter HTTP status code");
                continue;
            }
            if (scanner.next().equalsIgnoreCase("no")) {
                break;
            }
        }
        scanner.close();
    }
}

