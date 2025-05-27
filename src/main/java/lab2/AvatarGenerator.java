package lab2; //This is a user-defined package

import javax.imageio.ImageIO;// Importing a package that reads images and writes images to files
import javax.swing.*;// Importing package used to create GUI in desktop apps
import java.awt.*;// Importing package to build GUI graphics
import java.io.IOException;// Exception for reading and writing files
import java.io.InputStream;// Reading data from files
import java.net.URI;// Identifying webpages and files
import java.net.http.HttpClient;// Sending HTTP requests and receive responses
import java.net.http.HttpRequest;// Sends HTTP request
import java.net.http.HttpResponse;// Receives HTTP response

public class AvatarGenerator {// Class in the package lab2

    public static void main(String[] args) {

        try {
            var avatarStream = AvatarGenerator.getRandomAvatarStream();// Calling a class method requesting a random avatar.
            AvatarGenerator.showAvatar(avatarStream);// Calling a class method which displays the avatar in the GUI.
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();// Instance method of Throwable object.
        }

    }

    public static InputStream getRandomAvatarStream() throws IOException, InterruptedException {
        // Pick a random style
        String[] styles = { "adventurer", "adventurer-neutral", "avataaars", "big-ears", "big-ears-neutral", "big-smile", "bottts", "croodles", "croodles-neutral", "fun-emoji", "icons", "identicon", "initials", "lorelei", "micah", "miniavs", "open-peeps", "personas", "pixel-art", "pixel-art-neutral" };
        // styles is an array of strings with avatar names.
        var style = styles[(int)(Math.random() * styles.length)];
        //Math.random() is a class method

        // Generate a random seed
        var seed = (int)(Math.random() * 10000);// The seed is of type int

        // Create an HTTP request for a random avatar
        var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed));
        // URI.create(...) is a class method that creates a URI object from the string
        //.formatted(...) is a class method of a String. which returns a formatted string
        var request = HttpRequest.newBuilder(uri).build();
        // HttpRequest.newBuilder is a class method returning a builder object
        //.build is an instance method that constructs the http request

        // Send the request
        try (var client = HttpClient.newHttpClient()) {// Class method returning the new HttpClient instance
            // client is a reference type
            var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            // .send is an instance method of HttpClient that sends requests and receives HttpResponse
            // HttpResponse.BodyHandlers.ofInputStream is a class variable which returns a handler that gets InputStream as a response
            return response.body();// An instance method of HttpResponse
            // Returns the InputStream containing the image data
        }
    }

    public static void showAvatar(InputStream imageStream) {
        // imageStream is a reference type
            JFrame frame = new JFrame("PNG Viewer");// JFrame is a reference type variable
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // .setDefaultCloseOperation is an instance method that sets the default operation for when the user closes the frame
            frame.setResizable(false);
            // .setResizable is an instance method which doesn't allow the window to be resized
            frame.setSize(200, 200);
            // .setSize is an instance method which makes the window size 200x200px
            frame.getContentPane().setBackground(Color.BLACK);
            // .getContentPane and .setBackgroundColor are both instance methods
            try {
                // Load the PNG image
                Image image = ImageIO.read(imageStream);
                // .read is an instance method which returns an image object

                // Create a JLabel to display the image
                JLabel imageLabel = new JLabel(new ImageIcon(image));
                // new JLabel is a constructor call which creates a Label to display the ImageIcon
                frame.add(imageLabel, BorderLayout.CENTER);
                // .add is an instance method which adds the image label to the center of the frame

            } catch (IOException e) {
                e.printStackTrace();
                // .print... is an instance method
            }

            frame.setVisible(true);
        // .setVisible is an instance method that makes the frame visible
    }
}
