public class CapitalizeDecorator extends Decorator {
    public CapitalizeDecorator(Nameable nameable) {
        super(nameable);
    }

    @Override
    public String correctName() {
        String originalName = super.correctName();
        return originalName.toUpperCase();
    }
}
