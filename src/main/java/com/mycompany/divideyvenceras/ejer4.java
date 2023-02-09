/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.divideyvenceras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author SAMUEL
 */
public class ejer4
{ 
    static long[][] nd= new long[200000][3];
    static int[][] sd=new int[200001][2];
    static long[] res= new long[200001];
    public static void main(String[] abc) throws FileNotFoundException{
        //recopilar 
        FastReader sc= new FastReader();
        int n= sc.nextInt();
        nd= new long[n+1][3];
        int m=sc.nextInt();
        sd= new int[m+1][2];
        
        for(int i=0;i<n-1;i++){
           nd[i][0]=sc.nextInt();
           nd[i][1]=sc.nextInt();
           nd[i][2]=sc.nextInt();
           rank[i+1]=1;
           par[i+1]=-1;
        }
        rank[n]=1;
        par[n]=-1;
        mergeSort3(nd, 0, n-2);
        for(int i=0;i<m;i++){
            sd[i][0]=sc.nextInt() ; 
            sd[i][1] = i;
        }
        mergeSort2(sd,0,m-1);
        
        long cont=0;
        int indes=0;
        for(int i=0;i<m;i++){
            long val= sd[i][0];
            while(indes<n-1 && nd[indes][2]<=val){
                cont+=merge((int)nd[indes][0],(int)nd[indes][1]);
                indes++;
            }
            res[sd[i][1]]= cont;
        }
        for(int i=0;i<m;i++){
            System.out.print( res[i]+" ");
        }
	
    }
    static int[] par= new int[200001];
    static long[] rank= new long[200001];
   
    static int find(int a){
        if(par[a]==-1){ //
            return a;
        }
        return par[a]=find(par[a]);
    }
    static long merge(int a, int b){
        a=find(a);
        b=find(b);
        long res= rank[a]*rank[b];
        rank[a]+=rank[b];
        par[b]=a;
        return res;
    }
    
    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException 
        { 
            br = new BufferedReader( 
                //new InputStreamReader(System.in)); 
                   new FileReader("C:\\Users\\SAMUEL\\Documents\\4to semestre\\alg avan\\1510\\ej4.txt"));
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() { return Integer.parseInt(next()); } 
  
        long nextLong() { return Long.parseLong(next()); } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try { 
                if(st.hasMoreTokens()){ 
                    str = st.nextToken("\n"); 
                } 
                else{ 
                    str = br.readLine(); 
                } 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    static void merge2(int a[][], int beg, int mid, int end)    
{    
    int i, j, k;  
    int n1 = mid - beg + 1;    
    int n2 = end - mid;    
      
   /* temporary Arrays */  
        int LeftArray[][] = new int[n1][2];  
        int RightArray[][] = new int[n2][2];  
      
    /* copy data to temp arrays */  
    for (i = 0; i < n1; i++){    
    LeftArray[i][0] = a[beg + i][0];  
    LeftArray[i][1] = a[beg + i][1];
    }
    for (j = 0; j < n2; j++){    
    RightArray[j][0] = a[mid + 1 + j][0];    
    RightArray[j][1] = a[mid + 1 + j][1];
    }
    i = 0; /* initial index of first sub-array */  
    j = 0; /* initial index of second sub-array */   
    k = beg;  /* initial index of merged sub-array */  
      
    while (i < n1 && j < n2)    
    {    
        if(LeftArray[i][0] <= RightArray[j][0])    
        {    
            a[k] = LeftArray[i];    
            i++;    
        }    
        else    
        {    
            a[k] = RightArray[j];    
            j++;    
        }    
        k++;    
    }    
    while (i<n1)    
    {    
        a[k] = LeftArray[i];    
        i++;    
        k++;    
    }    
      
    while (j<n2)    
    {    
        a[k] = RightArray[j];    
        j++;    
        k++;    
    }    
}    
  
static void mergeSort2(int a[][], int beg, int end)  
{  
    if (beg < end)   
    {  
        int mid = (beg + end) / 2;  
        mergeSort2(a, beg, mid);  
        mergeSort2(a, mid + 1, end);  
        merge2(a, beg, mid, end);  
    }  
} 
static void merge3(long a[][], int beg, int mid, int end)    
{    
    int i, j, k;  
    int n1 = mid - beg + 1;    
    int n2 = end - mid;    
      
   /* temporary Arrays */  
        long LeftArray[][] = new long[n1][3];  
        long RightArray[][] = new long[n2][3];  
      
    /* copy data to temp arrays */  
    for (i = 0; i < n1; i++){    
    LeftArray[i][0] = a[beg + i][0];  
    LeftArray[i][1] = a[beg + i][1];
    LeftArray[i][2] = a[beg + i][2];
    }
    for (j = 0; j < n2; j++){    
    RightArray[j][0] = a[mid + 1 + j][0];    
    RightArray[j][1] = a[mid + 1 + j][1];
    RightArray[j][2] = a[mid + 1 + j][2];
    }
    i = 0; /* initial index of first sub-array */  
    j = 0; /* initial index of second sub-array */   
    k = beg;  /* initial index of merged sub-array */  
      
    while (i < n1 && j < n2)    
    {    
        if(LeftArray[i][2] <= RightArray[j][2])    
        {    
            a[k] = LeftArray[i];    
            i++;    
        }    
        else    
        {    
            a[k] = RightArray[j];    
            j++;    
        }    
        k++;    
    }    
    while (i<n1)    
    {    
        a[k] = LeftArray[i];    
        i++;    
        k++;    
    }    
      
    while (j<n2)    
    {    
        a[k] = RightArray[j];    
        j++;    
        k++;    
    }    
}    
  
static void mergeSort3(long a[][], int beg, int end)  
{  
    if (beg < end)   
    {  
        int mid = (beg + end) / 2;  
        mergeSort3(a, beg, mid);  
        mergeSort3(a, mid + 1, end);  
        merge3(a, beg, mid, end);  
    }  
} 
}
