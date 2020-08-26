public class mys {
  public static int mystery(int[] inputArray, int k) {
     int x = inputArray[k];
     int answer = k;
     int index = k + 1;
     while (index < inputArray.length) {
       if (inputArray[index] < x) {
            x = inputArray[index];
            answer = index;
       }
        index = index + 1;
     }
        return answer;
}

  public static void mystery2(int[] inputArray) {
    int index = 0;
    while (index < inputArray.length) {
      int targetIndex = mystery(inputArray, index);
      int temp = inputArray[targetIndex];
      inputArray[targetIndex] = inputArray[index];
      inputArray[index] = temp;
      index = index + 1;
    }
    for (int a: inputArray) System.out.print(a + " ");
  }

  public static void main(String[] args){
    int[] array={3, 0, 4, 6, 4};
    for (int a: array) System.out.print(a + " ");
    System.out.println(" ");
    mystery2(array);
  }
}
