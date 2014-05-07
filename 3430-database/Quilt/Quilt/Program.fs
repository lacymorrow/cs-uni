//SKELETON QUILT PROJECT


module Quilting
  open System.Drawing;;

  type Texture =  | Arcs 
                  | Bands;;

  type Direction = | NE
                   | SE
                   | SW
                   | NW;;
                 
  type square = Texture * Direction;;  // a 2-tuple


  type Square = 
    val square : Texture * Direction  
    new (tex,dir) = { square = (tex,dir) };;
  
  type Row = 
    val row : List<Square>
    new (list) = { row = list };;

  type Quilt = 
    val quilt : List<Row>
    new (list) = { quilt = list };;
  //-----------------------------------------------                 

  let a = [[(Arcs,NE)]];;
  let b = [[(Bands,NE)]];;

  //-----------------------------------------------                 
  // These functions are for image handling purposes.
  //-----------------------------------------------                 
  let encodeImage square =
    match square with
    | Bands,NE ->  new Bitmap(@"bandsNE.jpeg");
    | Bands,SE ->  new Bitmap(@"bandsSE.jpeg");
    | Bands,SW ->  new Bitmap(@"bandsSW.jpeg");
    | Bands,NW ->  new Bitmap(@"bandsNW.jpeg");
    | Arcs,NE -> new Bitmap(@"arcsNE.jpeg");
    | Arcs,SE -> new Bitmap(@"arcsSE.jpeg");
    | Arcs,SW -> new Bitmap(@"arcsSW.jpeg");
    | Arcs,NW -> new Bitmap(@"arcsNW.jpeg");
    //******Problem happening right here^^^



  let stitchRowImage r = List.map encodeImage r;;

  let rec calcWidth (r : List<Bitmap>) width = 
    match r with
    | [] -> width
    | hd::td -> let r = calcWidth td width
                hd.Width + r;;
           
  let rec calcHeight x = 
    match x with 
    | [] -> 0
    | hd::td -> 80 + calcHeight td;;
                     
  let calcRowWidth r = calcWidth r 0;;
  
  let saveFinalImage (bitmaps : List<List<Bitmap>>) (final : Bitmap) = 
    let g = Graphics.FromImage(final)
    let mutable widthOffset = 0
    let mutable heightOffset = 0
    for row in bitmaps do
      widthOffset <- 0
      for b in row do
        g.DrawImage(b, new Rectangle(widthOffset, heightOffset, 80, 80))
        widthOffset <- widthOffset + 80;
      heightOffset <- heightOffset + 80  
    final.Save(@"stitchedImage.jpg", System.Drawing.Imaging.ImageFormat.Jpeg);;
   

  let createQuiltImage x = let bitmaps = List.map stitchRowImage x
                           let width = calcRowWidth (List.head bitmaps)
                           let height = calcHeight bitmaps
                           let final = new Bitmap(width, height)
                           saveFinalImage bitmaps final;;

  // a useful function for some base cases perhaps
  let rec emptyquilt q =
    match q with
    | [] -> true
    | []::tl -> emptyquilt tl
    | hd::tl -> false;;

  // WRITE THIS FUNCTION BASED ON OUR DISCUSSION
  let clockwise dir = 
    match dir with
    | NE -> SE
    | SE -> SW
    | SW -> NW
    | NW -> NE;;
  
  // WRITE THIS FUNCTION BASED ON OUR DISCUSSION
  let turnsq square =
    (fst square, clockwise (snd square));;
  
  // WRITE THIS FUNCTION BASED ON OUR DISCUSSION
  let rec sew quiltOne quiltTwo =
    if quiltOne = [] && quiltTwo = [] then []
    else ((List.head quiltOne) @ (List.head quiltTwo))::
         sew (List.tail quiltOne) (List.tail quiltTwo);;
    
  // WRITE THIS FUNCTION BASED ON OUR DISCUSSION
  let rec turn x = 
    if emptyquilt x = true then []
    else
        let col = List.map List.head x
        List.rev (List.map turnsq col)::turn (List.map List.tail x);;
    
  // WRITE THIS FUNCTION BASED ON OUR DISCUSSION
  let unturn x = turn (turn (turn x));;
 
  // WRITE THIS FUNCTION
  let pile x y = unturn (sew (turn y) (turn x));;


  let slice = 
    let aa = pile (unturn a) (turn a)
    let bb = pile b (turn (turn b))
    let q = sew aa bb
    pile q q;;

  let our_quilt =
    let q = sew slice slice
    sew q slice;;
                         

  let quiltImage = createQuiltImage our_quilt;;