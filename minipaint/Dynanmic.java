public class Dynanmic {
  private Object[] entities;
  private int size, iterator = 0;

  Dynanmic(int size) {
    System.out.println(size);
    this.size = size != 0 ? size : 500;
    entities = new Object[this.size];
  }

  Dynanmic() {
    this.size = 500;
    entities = new Object[this.size];
  }

  public void add(Object tag) {
    if(iterator == size)
      expand();
    System.out.println(tag.toString());
    entities[iterator] = tag;
    iterator++;
  }

  public void add(Object tag, int index) {
    if (iterator == size)
      expand();
    for(int i = iterator - 1; i >= index; i--)
      entities[i + 1] = entities[i];
    System.out.println(tag.toString());
    entities[index] = tag;
    iterator++;
  }

  protected void expand() {
    Object[] entityTransfer = new Object[size == iterator ? size * 2 : 500 * 2];
    for(int i = 0; i < size; i++)
      entityTransfer[i] = entities[i];
    entities = entityTransfer;
    size *= 2;
  }
}
