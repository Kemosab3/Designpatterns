// Abstract UIElement class
abstract class UIElement {
    protected String text;

    public UIElement(String text) {
        this.text = text;
    }

    public abstract void display();

    public void setText(String text) {
        this.text = text;
    }
}

// Concrete Button class
class Button extends UIElement {
    public Button(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println(" [ " + text + " ] ");
    }
}

// Concrete TextField class
class TextField extends UIElement {
    public TextField(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println(" -[ " + text + " ]- ");
    }
}

// Concrete Checkbox class
class Checkbox extends UIElement {
    public Checkbox(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[ ] " + text);
    }
}

// Abstract UIFactory class
abstract class UIFactory {
    public abstract UIElement createButton(String text);

    public abstract UIElement createTextField(String text);

    public abstract UIElement createCheckbox(String text);
}

// Concrete ButtonFactory class
class ButtonFactory extends UIFactory {
    @Override
    public UIElement createButton(String text) {
        return new Button(text);
    }

    @Override
    public UIElement createTextField(String text) {
        return new TextField(text);
    }

    @Override
    public UIElement createCheckbox(String text) {
        return new Checkbox(text);
    }
}

// Application class
public class UIApplication {
    public static void main(String[] args) {
        // Create a Button using ButtonFactory
        UIFactory buttonFactory = new ButtonFactory();
        UIElement button = buttonFactory.createButton("Button");
        button.display();

        // Create a TextField using ButtonFactory
        UIElement textField = buttonFactory.createTextField("Enter text");
        textField.display();

        // Create a Checkbox using ButtonFactory
        UIElement checkbox = buttonFactory.createCheckbox("Checkbox");
        checkbox.display();

        // Change the content dynamically
        button.setText("New Text");
        textField.setText("Updated Text");
        checkbox.setText("Checked");

        // Display after updating content
        button.display();
        textField.display();
        checkbox.display();
    }

    public void run() {
    }
}
