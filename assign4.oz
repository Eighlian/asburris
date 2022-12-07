functor
   
import
   Application System

define     
fun{Fib X}       
fun{Loop X A B}          
if X == 0 then            
 B         
  else            
   {Loop X-1 A+B A}          
   end       
   end    
   in           
   {Loop X 1 0}    
   end  local    
   S in    
   S = {NewCell ""}    
   for I in 1..16 do        
    S := {Append {Append @S {Int.toString {Fib I}}} ", "}    
   end
   
 {System.showInfo {Append @S "..."}}    
 {Application.exit 0}
	end
end