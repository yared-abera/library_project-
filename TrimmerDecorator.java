 public class TrimmerDecorator extends Decorator {
    public TrimmerDecorator(Nameable nameable) {
        super(nameable);
    }

    @Override
    public String correctName() {
         String originalName = super.correctName();
         return originalName.length() > 10 ? originalName.substring(0, 10) : originalName;
    }
}

