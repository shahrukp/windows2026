package com.example.windows.code.task;


import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RequestMapping("/api/master/")
@RestController
public class MasterContro {
@Lazy
    RevserTheString revserTheString=new  RevserTheString();

        FailSafe failSafe =new FailSafe();

        FailFasts failFasts=new  FailFasts();

        FindHighesSecondEmpolyee findHighesSecondEmpolyee =new FindHighesSecondEmpolyee();

        FindDuplicateInGivenArray findDuplicateInGivenArray=new FindDuplicateInGivenArray();

        PrimeNumber primeNumber=new PrimeNumber();

        CountDigit countDigit=new CountDigit();

        FindMaxAndMin findMaxAndMin=new FindMaxAndMin();
        MakrfirstCharUpper makrfirstCharUpper=new MakrfirstCharUpper();

        ArragramStringCheckNumber arragramStringCheckNumber=new ArragramStringCheckNumber();


        FindMissingnumberInArray findMissingNumbe=new FindMissingnumberInArray();


        LengthOfTheLastWord lengthOfTheLastWord=new LengthOfTheLastWord();

        SecondSmallestNumber secondSmallestNumber =new SecondSmallestNumber();


        SecondLargestNumber secondLargestNumber = new SecondLargestNumber();


        CallBothCompartorAndComparable c=new CallBothCompartorAndComparable();


        AllFunctionInterfaceDemo allFunctionInterfaceDemo =new AllFunctionInterfaceDemo();


        ConsumerFunction consumerFunction =new ConsumerFunction();

        LambdaExperssions lambdaExperssions =new LambdaExperssions();


        ConvertCollectionIntoStreamAPI collectionintostream=new ConvertCollectionIntoStreamAPI();

        GapCalulation gapCalculation =new GapCalulation();

        GapCalulation gapCalulation =new GapCalulation();

        ReverseTheArray reverseTheArray =new ReverseTheArray();

        FindTheSecondlargestElementInArray findTheSecondlargestElementInArray =new FindTheSecondlargestElementInArray();

        CountEachCharInString countEachCharInString =new CountEachCharInString();

        re  res=new re(); // revser the string
        FindEvenNumber findEvenNumber =new FindEvenNumber();

        NumberStartingWithOne numberStartingWithOne =new NumberStartingWithOne();


        SwapVariables swapVariables =new SwapVariables();

        isPrimeNumber isPrimeNumber =new isPrimeNumber();


        FindDuplicateInArray duplicateInArray =new FindDuplicateInArray();
        FindTheTotalNumberOfElements findTheTotalNumberOfElements =new FindTheTotalNumberOfElements();

        FindMaxElement findMaxElement =new FindMaxElement();

        FirstNonRepeated firstNonRepeated =new FirstNonRepeated();

        SortValues sortValues =new  SortValues();


        ConcatenateTwoList concatenateTwoList =new ConcatenateTwoList();

        CubeNmbersGreaterThan cubeNmbersGreaterThan =new CubeNmbersGreaterThan();

        flatMap flatMap
                 =new flatMap();

        ReverseTheString reverseTheString =new ReverseTheString();

//http://localhost:8081/api/master/get
    @GetMapping("get")
    public String callRandomMethod() throws InterruptedException {
       // return revserTheString.revserTheString();
       // return failSafe.FailSafeDemo();
     //   return failFasts.FailSafeDemo();
//        return reverseTheArray.forChecker();
      ////
        // return findHighesSecondEmpolyee.fincsecondHingheEmp();
       // return findDuplicateInGivenArray.findDuplicate();
       // return findDuplicateInGivenArray.findMultipleDuplicate();
      //  return findDuplicateInGivenArray.nonFirstrepeatingChar();
       // return findMaxAndMin.findMaxMinstreamAPI();
        //return countDigit.countDigitViaStream();
      //  return primeNumber.primeNumber();
     //   return makrfirstCharUpper.toUpperCasess();
     //  return findMissingNumbe.findMultipleMissingNumber();
      //  return  gapCalulation.GapCalculation();
    //    return  reverseTheArray.reverseArray();

      //  return  findTheSecondlargestElementInArray.findSecondLargeElements();
      //  return  res.reS();
       // return  findEvenNumber.EvenNumber();
        //return duplicateInArray.findDuplicate();
       // return  firstNonRepeated.firstNonRepeatedChar();
       // return flatMap.flatMap();
        return  reverseTheString.revserTheString();

    }}
