package structure.proxy;

/**
 * The object to be proxyed.
 */
public class IvoryTower implements WizardTower {

    public void enter(Wizard wizard) {
        System.out.printf("%s enters the tower.\n", wizard);
    }

}
