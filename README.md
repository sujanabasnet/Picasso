# Picasso

An application that allows the user to create expressions that
evaluate to colors and then eventually to images.

The given code base is a good start, but it is sparsely documented
(document each method/part after you understand what it's doing) and,
as your application grows, you may need to refactor.

See the specification for Picasso on the course web site

## Project Organization

`src` - the source code for the project

`conf` - the configuration files for the project

The `images` directory contains some sample images generated from Picasso.  Some of the expressions for these images can be found in the `expressions` directory.

Within our `expressions` directory we contain the following functions: Absolute Value(Abs), ArcTangent(Atan), Ceil, Clamp, Cos, Exponetial(Exp), Floor, ImageWrap, Log, PerlinBW, PerlinColor, Randomizer, Rgbtoycrcb, Sin, Tan, Wrap, and Ycrcbtorgb

Within our `expressions` directory we contain the following operators: Addition, Division, Exponentiate, Modulo(Mod), Multiplication, and Subtraction.

### Team Memebers
Andrew Marsh,
Jared Cordova,
Praise Apata,
Sarah Martin,
Sujana Basnet


## Extensions

1. View multiple images at once in separate windows - Users can view the image in a different window by clicking on "Evaluate in a new window" button. 
2. Generate an image from a string - Users can evaluate strings using the following syntax: strings("stringToEvaluate").
3. Easily combine saved expressions into new expressions - Users can assign an expression to a variable using the equals sign. Users have to click on the "Evaluate" button in order to allow the program to save the variable reference. To create new expressions by combining saved expression, users can use the variable names.
4. Allow users to save a history of old expressions as well as evaluate the history - Users can save any input by clicking the "Save Input" button. Please note that clicking on the "Save Input" button will not evaluate the expression. However, once saved, users can click on the expression of their choice to move the expression back into the "Enter Expression:" textfield, where the expression can then be evaluated. If you want to save an assignment in the Picasso language, you will have to evaluate it at least once. 
5. Allow users to use the up and down arrows to move through the history of expressions - Click the arrows to move up and down in the history of evaluated expressions. Note that the expressions must be evaluated not just saved. Also note that expressions evaluated in a new window will not be saved in the history.
6. Generate expressions randomly - Users can evaluate random expressions by clicking on the "Evaluate" or "Evaluate in a new window" button without adding any input to the text field. The random expression will appear on the text field once the evaluate button is clicked. If evaluating in a new window, the random expression will be on the title of the new window. The text field should be cleared using the "Clear" button before evaluating a new random expression.

