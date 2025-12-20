package com.example.windows.codingtaksonly_2026;

import com.example.windows.collection2026.CollectionInterfaceVsCollectionsClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;


@RequestMapping("/coding/task/")
@RestController
public class MasterControllerCallCodingTaks {

    // master endpoint
    // localhost:8080/coding/task/methodname
    @Autowired
    private CodingTaksOnly codingTaksOnly;


    @Autowired
    private ReverseTheString reverseTheString;

    @Autowired
    ReverseTheArray reverseTheArray;

    @Autowired
    FindSecondLargeElement findSecondLargeElement;


    @Autowired
    OptonalClass optonalClass;

    @Autowired
    ParllalArray parllalArray;

    @Autowired
    ForEachMethod forEachMethod;



    @Autowired
    SupplierInterface supplierInterface;

    @Autowired
    ConsumerVsBiConsumer consumerVsBiConsumer;

    @Autowired
    MoveZeroToLeftSideRight moveZeroToLeftSideRight;

    @Autowired
    FunctionVsBiFunctionInterface functionVsBiFunctionInterface;

   @Autowired
           @Lazy
    PredicateViBiPredicate predicateViBiPredicate;

   @Autowired
    MapVsFllatMap mapVsFllatMap;


   @Autowired
    IntStreams intStreams;

   @Autowired
    CallableVsRunableInterface callableVsRunableInterface;


   @Autowired
   CollectionInterfaceVsCollectionsClass collectionInterfaceVsCollectionsClass;

    @GetMapping("/{methodName}")
    //public ResponseEntity<String> invokedMethod(@PathVariable String methodName){
    public String invokedMethod(@PathVariable String methodName) {
        try {
            Method method = collectionInterfaceVsCollectionsClass.getClass().getDeclaredMethod(methodName);
            // return  new ResponseEntity((HttpStatusCode) method.invoke(javaAllinCodedemo, HttpStatus.ACCEPTED));
            return (String) method.invoke(collectionInterfaceVsCollectionsClass);
        } catch (Exception e) {
            //  return  new ResponseEntity<>( "invalid method ", HttpStatus.BAD_GATEWAY);
            // return  "invalid file name";
        }
        return "something went wrong ..............? !" ;
    }
}
