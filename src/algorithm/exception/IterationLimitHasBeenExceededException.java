/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.exception;

/**
 *
 * @author Kamil-Tomasz
 */
public class IterationLimitHasBeenExceededException extends RuntimeException {
    
    public IterationLimitHasBeenExceededException(long limit, long current) {
        super("limit: " + limit + ", current: " + current);
    }
}
