import java.util.ArrayList;
import java.util.List;

public class MaterialManager {
    private List<Material> materials;

    public MaterialManager(List<Material> materials) {
        this.materials = materials;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public double getTotalCost() {
        double total = 0;
        for (Material material : materials) {
            total += material.getAmount();
        }
        return total;
    }
    public double getTotalRealCost() {
        double total = 0;
        for (Material material : materials) {
            if (material instanceof Discount)
                total += ((Discount) material).getRealCost();
        }
        return total;
    }

    public List<Material> sortByCost() {
        List<Material> sorted = new ArrayList<Material>();
        for (int i = 1; i < materials.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (materials.get(j - 1).getCost() > materials.get(j).getCost()) {
                    Material temp = materials.get(j);
                    materials.set(j, materials.get(j - 1));
                    materials.set(j - 1, temp);
                }
            }
        }
        return sorted;
    }
}
