package be.bstorm.ylorth;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InitDB.initialisation();

        RequeteSimple.delete(12);
        RequeteSimple.delete(4);

        List<Javanais> javanais = RequeteSimple.getAll();
        javanais.get(3).setNumeroRoueInfortune(4);
        javanais.get(4).setNumeroRoueInfortune(5);
        javanais.get(5).setNumeroRoueInfortune(6);
        javanais.get(6).setNumeroRoueInfortune(7);
        javanais.get(7).setNumeroRoueInfortune(8);
        javanais.get(8).setNumeroRoueInfortune(10);
        javanais.get(9).setNumeroRoueInfortune(9);

        for (Javanais javanai : javanais) {
            RequeteSimple.update(javanai.getId(), javanai);
        }

        for (Javanais javanai : RequetePreparee.getAllWithCar()) {
            System.out.println(javanai);
        }

    }
}