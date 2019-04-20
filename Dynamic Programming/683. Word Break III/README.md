# Word Break III

Give a dictionary of words and a sentence with all whitespace removed, return the number of sentences you can form by inserting whitespaces to the sentence so that each word can be found in the dictionary.

**Case insensitive.**

### Example1

Input:
`"CatMat"`  
`["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]`  
Output: `3`  

Explanation:  
we can form 3 sentences, as follows:  
```
"CatMat" = "Cat" + "Mat"
"CatMat" = "Ca" + "tM" + "at"
"CatMat" = "C" + "at" + "Mat"
```

### Example2

Input:  
`"a"`  
`[]`  
Output: `0`