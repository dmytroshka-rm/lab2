package com.patient;

import com.patient.model.Patient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Скільки пацієнтів ви хочете ввести?");
        int n = scanner.nextInt();
        scanner.nextLine();
        Patient[] patients = new Patient[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nВведення даних пацієнта №" + (i + 1));

            System.out.print("Прізвище: ");
            String lastName = scanner.nextLine();

            System.out.print("Ім'я: ");
            String firstName = scanner.nextLine();

            System.out.print("По-батькові: ");
            String secondName = scanner.nextLine();

            System.out.print("Адреса: ");
            String address = scanner.nextLine();

            String number;
            while (true) {
                System.out.print("Телефон: ");
                number = scanner.nextLine();
                if (!existsPhone(number, patients, i)) {
                    break;
                }
                System.out.println("Такий номер телефону вже існує.Введіть інший.");
            }

            int id;
            while (true) {
                System.out.print("ID: ");
                id = scanner.nextInt();
                scanner.nextLine();
                if (!existsId(id, patients, i)) {
                    break;
                }
                System.out.println("Такий ID вже існує.Введіть інший.");
            }

            int numMedCard;
            while (true) {
                System.out.print("Номер медичної картки: ");
                numMedCard = scanner.nextInt();
                scanner.nextLine();
                if (!existsMedCard(numMedCard, patients, i)) {
                    break;
                }
                System.out.println("Такий номер медичної картки вже існує.Введіть інший.");
            }

            System.out.print("Діагноз: ");
            String diagnos = scanner.nextLine();

            Patient patient = new Patient(id,firstName,secondName,lastName,address,number,numMedCard,diagnos);
            patients[i] = patient;
        }

        System.out.print("\nВведіть діагноз для пошуку: ");
        String searchDiag = scanner.nextLine();
        printByDiagnos(searchDiag, patients);

        System.out.print("\nВведіть початок діапазону номера медкартки: ");
        int a = scanner.nextInt();
        System.out.print("Введіть кінець діапазону номера медкартки: ");
        int b = scanner.nextInt();
        scanner.nextLine();
        printByInterval(a, b, patients);

        System.out.print("\nВведіть цифру, з якої починається телефон: ");
        char digit = scanner.nextLine().charAt(0);
        printByPhoneDigit(digit, patients);

        scanner.close();
    }

    public static boolean existsId(int id, Patient[] patients, int count) {
        for (int i = 0; i < count; i++) {
            if (patients[i] != null && patients[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean existsPhone(String phone, Patient[] patients, int count) {
        for (int i = 0; i < count; i++) {
            if (patients[i] != null && patients[i].getNumber().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public static boolean existsMedCard(int num, Patient[] patients, int count) {
        for (int i = 0; i < count; i++) {
            if (patients[i] != null && patients[i].getNumMedCard() == num) {
                return true;
            }
        }
        return false;
    }

    public static void printByDiagnos(String diag, Patient[] patients) {
        System.out.println("\nПацієнти з діагнозом '" + diag + "':");
        for (Patient p : patients) {
            if (p.getDiagnos().equalsIgnoreCase(diag)) {
                System.out.println(p);
            }
        }
    }

    public static void printByInterval(int a, int b, Patient[] patients) {
        System.out.println("\nПацієнти з номером медкартки у діапазоні [" + a + ", " + b + "]:");
        for (Patient p : patients) {
            if (p.getNumMedCard() >= a && p.getNumMedCard() <= b) {
                System.out.println(p);
            }
        }
    }

    public static void printByPhoneDigit(char digit, Patient[] patients) {
        int count = 0;
        System.out.println("\nПацієнти, телефон яких починається з '" + digit + "':");
        for (Patient p : patients) {
            if (p.getNumber().charAt(0) == digit) {
                System.out.println(p);
                count++;
            }
        }
        System.out.println("Загальна кількість: " + count);
    }
}
