// Exercise 4.3 on page 7: short-circuit evaluation
let num = 4;;
let deno = 0;;
let short = deno <> 0 && num / deno > 2;;
// Short is bound to false, so the evaluation short-circuited
// End 4.3

// Exercise 4.4 on page 14: getAge
let getAge tuple =
let first, last, age = tuple
age;;
let tup = ("Grayson", "Fenwick", 16);;
getAge tup;;
// End 4.4

// Exercise 4.5 on page 16: The :: operator (include code that demonstrates its associativity)
let L1 = 1 :: 2 :: 3 :: [];;
let L2 = [] :: 3 :: 2 :: 1;;
// The :: operator is right associative; it expects a list to be the right operand
//  and operates from right to left, for example, L1 = 1::(2::(3::[]))
// End 4.5

let L1 = 1 :: 2 :: 3 :: [];; //This works
let L2 = [] :: 1 :: 2 :: 3;; //This does not
//stepping through from one of the above examples to the next and looking at where it gives the error
//leads me to believe that it is left associative, and either starts with a list or begins to form one


// Exercise 4.6 on page 20: The boolean "s" function
let rec s item list =
if list = [] then false
elif list.Head = item then true
else s item list.Tail;;
s 1 [1;2;3;4];;
s 2 [1;1;3;4];;
// End 4.6

// Exercise 4.7 on page 21: deleteFirst
let rec deleteFirst item list =
if list = [] then []
elif list.Head = item then list.Tail
else deleteFirst item list.Tail;;
deleteFirst 'a' ['a';'a';'b'];;
// End 4.7

// Exercise 4.8 on page 23: quickSort
let rec quickSort (xs) =
match xs with
| [] -> []
| hd::tl ->
let smaller = List.filter(fun e -> e < hd) xs
let equal = List.filter(fun e -> e = hd) xs
let larger = List.filter(fun e -> e > hd) xs
quickSort(smaller)@equal@quickSort(larger);;
quickSort [1;2;6;3;1];;
// End 4.8

// Exercise 4.9 on page 23: zip
// Status: Just fine
let rec mineZip L1 L2 =
if (List.isEmpty L1 && List.isEmpty L2) then []
elif (List.isEmpty L1) then None :: (mineZip [] (List.tail L2))
elif (List.isEmpty L2) then None :: (mineZip (List.tail L1) [])
else Some(List.head L1 , List.head L2) :: (mineZip (List.tail L1) (List.tail L2));;
mineZip [1;2;3;4] ['a';'b';'c'];;
// End 4.9

// Exercise 4.10 on page23-24: unzip
// Status: AOK
let rec bestUnzip list =
if (List.isEmpty list) then ([],[])
else
let head = List.head list
let tail = List.tail list
let unzippedYo = bestUnzip tail
((fst head)::(fst unzippedYo),(snd head)::(snd unzippedYo));;
bestUnzip [(1,'a');(2,'b');(3,'c')];;
// End 4.9
// End 4.10

// Exercise 4.11 on page 24-25: partition
// Status: fubar
let rec mypartition fun func li=
let l1 = func li;;
let rec mypartition li=
match li with
| [] -> []
// End 4.11

// Exercise 4.12 on page 26-27: reduce
// Status: MIA
// End 4.12

// Selection sort
// Status: WORKS
let rec selectionSort = function
| [] -> []
| l -> let min = List.min l in
let rest = List.filter (fun i -> i <> min) l in
let sortedList = selectionSort rest in
min :: sortedList;;
selectionSort [1;2;4;3;9;6;10;12314545];;
selectionSort [12333;4424;42;233;4;12;1;666;420;10;12314545];;
// End Selection sort

// doesAnyElementSatisfy
// Status: NO LONGER MIA
let dAeS func L1 =
if (List.isEmpty L1) then false
else if ((List.fold (fun acc item -> acc || item) false (List.map (func) L1))) then true
else false;;
dAeS (fun n -> n % 2 = 0) [1;3;5;6;7;9];;
dAeS (fun n -> n / 4 = 1) [1;3;5;6;7;9];;
dAeS (fun n -> n / 100 = 7) [1;3;5;6;7;9];;
// End doesAnyElementSatisfy



I'll just paste what I have. I got some different answers from him, and the ones that he did a video for I pretty much coppied from the video while watching it. but I cant imagine he isnt expecting that since he posted videos.

// SimpleFunctions.fs
// Jake Campos
// 11/27/12

// Exercise 4.3 on page 7: short-circuit evaluation
F# Does perform short-circuit evaluations.

//Exercise 4.4 on page 14: getAge
let tup = ("Grayson", "Fenwick", 16);;
let getAge tuple =
let first, last, age = tuple
age;;

// Exercise 4.5 on page 16: The :: operator (include code that demonstrates its associativity)
let L1 = 1 :: 2 :: 3 :: [];; //This works
let L2 = [] :: 1 :: 2 :: 3;; //This does not
//stepping through from one of the above examples to the next and looking at where it gives the error
//leads me to believe that it is left associative, and either starts with a list or begins to form one

// Exercise 4.6 on page 20: The boolean "s" function
let rec s item list =
if list = [] then false
elif list.Head = item then true
else s item list.Tail;;
s 5 [1;2;3;4];;
s 2 [1;2;3;4];;
s 1 [1;2;3;4];;
s 1 [];;

// Exercise 4.7 on page 21: deleteFirst
let rec delete_first item list =
match list with
| [] -> []
| hd::tl -> if hd = item then tl
else hd::delete_first item tl;;

//Exercise 4.8 on page 23: quickSort
let rec quicksort (xs) =
match xs with
| [] -> []
| hd::tl ->
let smaller = List.filter(fun e -> e < hd) xs
let equal = List.filter(fun e -> e = hd) xs
let larger = List.filter(fun e -> e > hd) xs
quicksort(smaller) @ equal @ quicksort(larger);;
quicksort [13;58;89;78;67;13;17;28;3789;45;45;58];;

//Exercise 4.9 on page 23: zip
let rec Zip2 L1 L2 =
match L1 with
| [] -> if L2 = []
then []
else [None]
| hd::tl -> if L2 = []
then [None]
else let tailtups = Zip2 tl (List.tail L2)
Some((hd, (List.head L2))) :: tailtups;;

//Exercise 4.10 on page23-24: unzip
let rec unzip L =
match L with
| [] -> ([], [])
| hd::tl -> let (hdele1, hdele2) = hd
let tup = unzip tl
let (tupele1, tupele2) = tup
(hdele1::tupele1, hdele2::tupele2);;
