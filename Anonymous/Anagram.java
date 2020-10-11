public class AnagramProgram
{
    static void isAnagram(String s1, String s2)
    {
        //Removing white spaces from s1 and s2 and converting case to lower
 
        String copyOfs1 = s1.replaceAll("\s", "").toLowerCase();
 
        String copyOfs2 = s2.replaceAll("\s", "").toLowerCase();
 
        //Initially setting status as true
 
        boolean status = true;
 
        if(copyOfs1.length() != copyOfs2.length())
        {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
 
            status = false;
        }
        else
        {
            //Converting copyOfs1 to char array
 
            char[] s1Array = copyOfs1.toCharArray();
 
            //Constructing StringBuilder from copyOfs2
 
            StringBuilder sb = new StringBuilder(copyOfs2);
 
            //Checking whether each character of s1Array is present in sb
 
            for (char c : s1Array)
            {
                int index = sb.indexOf(""+c);
 
                if (index != -1)
                {
                    //If present, removing that character from sb
 
                    sb = sb.deleteCharAt(index);
                }
                else
                {
                    //If not present, setting status as false and breaking the loop
 
                    status = false;
 
                    break;
                }
            }
        }
 
        //Output
 
        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
    }
 
    public static void main(String[] args)
    {
        isAnagram("Mother In Law", "Hitler Woman");
 
        isAnagram("keEp", "peeK");
 
        isAnagram("SiLeNt CAT", "LisTen AcT");
 
        isAnagram("Debit Card", "Bad Credit");
 
        isAnagram("School MASTER", "The ClassROOM");
 
        isAnagram("DORMITORY", "Dirty Room");
 
        isAnagram("ASTRONOMERS", "NO MORE STARS");
 
        isAnagram("Toss", "Shot");
 
        isAnagram("joy", "enjoy");
    }
}
