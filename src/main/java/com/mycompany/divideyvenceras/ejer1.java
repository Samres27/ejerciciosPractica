/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.divideyvenceras;
import java.util.*;
import java.io.*;
/**
 *
 * @author SAMUEL
 */
public class ejer1 {
    public static void main(String[] asd) throws IOException{
        BufferedReader sc= new BufferedReader(new FileReader("C:\\Users\\SAMUEL\\Documents\\4to semestre\\alg avan\\1510\\ej1.txt"));
        StringTokenizer st= new StringTokenizer(sc.readLine());
        int t= Integer.parseInt(st.nextToken());
        Stack<Integer> p=new Stack<>();
        
        while(t-->0){
            
            st= new StringTokenizer(sc.readLine());
            int n=Integer.parseInt(st.nextToken());
            int [] ls= new int[n];
            st= new StringTokenizer(sc.readLine());
            for(int i=0;i<n;i++){
                
                int num=Integer.parseInt(st.nextToken());
                p.add(num);
            }
            int res=0;
            BinaryIndexedTree tree=new BinaryIndexedTree() ;
            tree.constructBITree(ls, n);
            while(!p.isEmpty()){
                int fl=p.pop()-1;
                res+=tree.getSum(fl);
                tree.updateBIT(n,fl , 1);        
            }
            System.out.println(res);
        }
    }
     static class Reader { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream( 
                new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) { 
                if (c == '\n') { 
                    if (cnt != 0) { 
                        break; 
                    } 
                    else { 
                        continue; 
                    } 
                } 
                buf[cnt++] = (byte)c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') { 
                c = read(); 
            } 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') { 
                while ((c = read()) >= '0' && c <= '9') { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, 
                                 BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
}
class BinaryIndexedTree
{ 
    // Max tree size
    final static int MAX = 1000;     
  
    static int BITree[] = new int[MAX];
      
    /* n --> No. of elements present in input array. 
    BITree[0..n] --> Array that represents Binary 
                    Indexed Tree.
    arr[0..n-1] --> Input array for which prefix sum 
                    is evaluated. */
  
    // Returns sum of arr[0..index]. This function 
    // assumes that the array is preprocessed and 
    // partial sums of array elements are stored 
    // in BITree[].
    int getSum(int index)
    {
        int sum = 0; // Initialize result
      
        // index in BITree[] is 1 more than
        // the index in arr[]
        index = index + 1;
      
        // Traverse ancestors of BITree[index]
        while(index>0)
        {
            // Add current element of BITree 
            // to sum
            sum += BITree[index];
      
            // Move index to parent node in 
            // getSum View
            index -= index & (-index);
        }
        return sum;
    }
  
    // Updates a node in Binary Index Tree (BITree)
    // at given index in BITree. The given value 
    // 'val' is added to BITree[i] and all of 
    // its ancestors in tree.
    void updateBIT(int n, int index, 
                                        int val)
    {
        // index in BITree[] is 1 more than 
        // the index in arr[]
        index = index + 1;
      
        // Traverse all ancestors and add 'val'
        while(index <= n)
        {
        // Add 'val' to current node of BIT Tree
        BITree[index] += val;
      
        // Update index to that of parent 
        // in update View
        index += index & (-index);
        }
    }
  
    /* Function to construct fenwick tree 
    from given array.*/
    void constructBITree(int arr[], int n)
    {
        // Initialize BITree[] as 0
        for(int i=1; i<=n; i++)
            BITree[i] = 0;
      
        // Store the actual values in BITree[]
        // using update()
        for(int i = 0; i < n; i++)
            updateBIT(n, i, arr[i]);
    }
}