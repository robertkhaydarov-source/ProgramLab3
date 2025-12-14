package model;

import java.util.List;

public interface Watch {
    // Смотреть на конкретную картину
    void watchPicture(Picture picture);

    // Смотреть на все картины в списке
    default void watchAllPictures(List<Picture> pictures) {
        for (Picture picture : pictures) {
            watchPicture(picture);
        }
    }
//    // Реакция после просмотра
//    String getReaction();
}