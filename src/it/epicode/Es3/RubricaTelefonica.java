package it.epicode.Es3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RubricaTelefonica {
    private final Map<String, String> rubrica;

    public RubricaTelefonica() {
        rubrica = new HashMap<>();
    }

    public void inserisciContatto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci il numero di telefono: ");
        String numeroTelefono = scanner.nextLine();
        rubrica.put(nome, numeroTelefono);
        System.out.println("Contatto inserito con successo!");
    }

    public void eliminaContattoPerNome(String nome) {
        if (rubrica.containsKey(nome)) {
            rubrica.remove(nome);
            System.out.println("Contatto eliminato con successo!");
        } else {
            System.out.println("Contatto non trovato.");
        }
    }

    public String ricercaPersonaPerNumeroTelefono(String numeroTelefono) {
        for (Map.Entry<String, String> entry : rubrica.entrySet()) {
            if (entry.getValue().equals(numeroTelefono)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String ricercaNumeroTelefonoPerNome(String nome) {
        return rubrica.get(nome);
    }

    public void stampaRubrica() {
        if (rubrica.isEmpty()) {
            System.out.println("La rubrica è vuota.");
        } else {
            System.out.println("Contatti nella rubrica:");
            for (Map.Entry<String, String> entry : rubrica.entrySet()) {
                System.out.println("Nome: " + entry.getKey() + ", Numero di telefono: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        RubricaTelefonica rubricaTelefonica = new RubricaTelefonica();
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("  Rubrica Telefonica  ");
            System.out.println("1. Inserisci contatto");
            System.out.println("2. Elimina contatto");
            System.out.println("3. Ricerca persona per numero di telefono");
            System.out.println("4. Ricerca numero di telefono per nome");
            System.out.println("5. Stampa rubrica");
            System.out.println("0. Esci");
            System.out.print("Seleziona un'opzione: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    rubricaTelefonica.inserisciContatto();
                    break;
                case 2:
                    System.out.print("Inserisci il nome del contatto da eliminare: ");
                    String nome = scanner.nextLine();
                    rubricaTelefonica.eliminaContattoPerNome(nome);
                    break;
                case 3:
                    System.out.print("Inserisci il numero di telefono: ");
                    String numeroTelefono = scanner.nextLine();
                    String persona = rubricaTelefonica.ricercaPersonaPerNumeroTelefono(numeroTelefono);
                    if (persona != null) {
                        System.out.println("Persona trovata: " + persona);
                    } else {
                        System.out.println("Persona non trovata.");
                    }
                    break;
                case 4:
                    System.out.print("Inserisci il nome: ");
                    String nomeRicerca = scanner.nextLine();
                    String numero = rubricaTelefonica.ricercaNumeroTelefonoPerNome(nomeRicerca);
                    if (numero != null) {
                        System.out.println("Numero di telefono trovato: " + numero);
                    } else {
                        System.out.println("Numero di telefono non trovato.");
                    }
                    break;
                case 5:
                    rubricaTelefonica.stampaRubrica();
                    break;
                case 0:
                    System.out.println("Hai scelto di uscire.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }
}
