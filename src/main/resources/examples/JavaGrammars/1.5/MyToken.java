import com.learn.javacc.simple.simple1.Token;

public class MyToken extends Token
{
  /**
   * Constructs a new token for the specified Image and Kind.
   */
  public MyToken(int kind, String image)
  {
     this.kind = kind;
     this.image = image;
  }

  int realKind = JavaParserConstants.GT;

  /**
   * Returns a new com.learn.javacc.simple.simple1.Token object.
  */

  public static final Token newToken(int ofKind, String tokenImage)
  {
    return new MyToken(ofKind, tokenImage);
  }
}
