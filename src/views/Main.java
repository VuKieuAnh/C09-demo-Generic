package views;

import controller.MaterialManager;
import model.material.CrispyFlour;
import model.material.Material;
import model.material.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Material> materials = new ArrayList<>();
        materials.add(new CrispyFlour("F1", "FFW", LocalDate.of(2024,9,15), 100, 80));
        materials.add(new CrispyFlour("E1", "EVB", LocalDate.of(2024,9,22), 125, 12));
        materials.add(new CrispyFlour("W1", "WLM", LocalDate.of(2024,7,11), 219, 22));
        materials.add(new CrispyFlour("Q1", "QAL", LocalDate.of(2024,2,8), 99, 38));
        materials.add(new CrispyFlour("K1", "KJH", LocalDate.of(2024,3,29), 156, 25));
        materials.add(new Meat("RT1", "RTGS", LocalDate.of(2024,11,11), 371, 15.6));
        materials.add(new Meat("YH1", "YHUP", LocalDate.of(2024,10,8), 244, 40.1));
        materials.add(new Meat("XJ1", "XJQW", LocalDate.of(2024,11,3), 289, 32));
        materials.add(new Meat("LP1", "LPER", LocalDate.of(2024,11,4), 312, 51.3));
        materials.add(new Meat("AZ1", "AZMD", LocalDate.of(2024,11,5), 956, 8.9));

        MaterialManager materialManager = new MaterialManager(materials);

        System.out.println("=== List of Materials ===");
        for (Material material : materials) {
            System.out.println(material);
        }

        System.out.println("\nTotal cost of all material: " + materialManager.getTotalCost());
        System.out.println("\nTotal real cost of all material: " + materialManager.getTotalRealCost());

        List<Material> sortedMaterials = materialManager.sortByCost();
        System.out.println("=== Materials sorted by cost ===");
        for (Material material : materials) {
            System.out.println(material);
        }

        System.out.println("Value different between cost and real cost: " + (materialManager.getTotalCost() - materialManager.getTotalRealCost()));
    }
}
