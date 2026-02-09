TMMC Programming Assignment - Java

How to run:

1. Compile:
   javac VerticalLineCounter.java

2. Run:
   java VerticalLineCounter <absolute_image_path>

Example:
   java VerticalLineCounter C:\TMMC_interview_assignment\img_4.jpg

Output:
   Prints the number of vertical black lines in the image.

Notes:
- Accepts exactly one argument
- Handles invalid input and exceptions gracefully


While testing img_4.jpg, a vertical line touching the image boundary
was not detected using a full-height pixel percentage approach.

To resolve this, the algorithm was refined to verify the presence of
black pixels independently in both the top and bottom halves of the image,
which aligns with the problem constraint that lines are continuous.
