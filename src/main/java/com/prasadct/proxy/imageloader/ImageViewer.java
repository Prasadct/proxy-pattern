package com.prasadct.proxy.imageloader;

// Client code
public class ImageViewer {
    public static void main(String[] args) {
        // Create an array of images
        Image[] images = new Image[3];
        images[0] = new ProxyImage("image1.jpg");
        images[1] = new ProxyImage("image2.jpg");
        images[2] = new ProxyImage("image3.jpg");

        // Images are not loaded until display() is called
        System.out.println("Images will be loaded on demand...");

        // Load and display the first image
        System.out.println("\nDisplaying first image:");
        images[0].display();

        // Display the first image again (already loaded)
        System.out.println("\nDisplaying first image again:");
        images[0].display();

        // Load and display the second image
        System.out.println("\nDisplaying second image:");
        images[1].display();
    }
}