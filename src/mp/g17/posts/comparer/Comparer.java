/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts.comparer;

/**
 *
 * @author usuario
 */
public interface Comparer <O> {
    int compare (O x, O y);
}
