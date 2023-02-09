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
public class ejer1b {
    
    
    

public static void main (String[] args) throws java.lang.Exception
	{
	
        FastReader sc= new FastReader();
        int t= sc.nextInt();
        
        while(t-->0){
            int n=sc.nextInt();
            int [] a= new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                
            }
            int res= merge_sort(a,0,n-1); //hasta aqui en problema de inversion de un array
            int reps= 1;
                 for (int i = 1; i < n; i++) {
                     if (a[i] != a[i - 1]) {res += (reps * (reps - 1)) / 2; reps= 1;}
                     else {reps++;}
                 }
                 res += (reps * (reps - 1)) / 2;
            System.out.println(res);
        }
}
static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader( 
                new InputStreamReader(System.in)); 
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
static int merge(int arr[],int l,int mid,int r){
    int[] temp = new int[r-l+1];
    int i=l,j=mid+1;
    int t=0;
    int res=0;
    while(i<=mid && j<=r){
        if(arr[i]<=arr[j]){
            temp[t++]=arr[i++];
            
        }
        else{
            temp[t++]=arr[j++];
            res+=(mid-i+1);
        }
    }
    while(i<=mid){
        temp[t++]=arr[i++];
    }
    while(j<=r){
        temp[t++]=arr[j++];
    }
    t=0;
    for(int ti=l;ti<=r;ti++){
        arr[ti]=temp[t++];
    }
    //delete [] temp;
    return res;
}


   static int merge_sort(int arr[],int l,int r){
    int res=0;
    if(l>=r){
        return res;
    }
    
    int mid=(l+r)/2;
    
    res=merge_sort(arr,l,mid);      //recursive calls to sort left part
    res+=merge_sort(arr,mid+1,r);    //recursive calls to sort right part
    
    res+=merge(arr,l,mid,r);
    
    return res;
    }
}
