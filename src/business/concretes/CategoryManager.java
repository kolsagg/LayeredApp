package business.concretes;

import business.abstracts.ICategoryManager;
import core.logging.abstracts.ILogger;
import dataAccess.abstracts.ICategoryDao;
import entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager implements ICategoryManager {
    private final ICategoryDao categoryDao;
    private final ILogger[] loggers;
    private static final List<Category> categoryList = new ArrayList<>();

    public CategoryManager(ICategoryDao categoryDao, ILogger[] loggers) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
    }

    @Override
    public void add(Category category) throws Exception {
        //kontrol algoritması yazılacak
        if (categoryList.isEmpty()) {
            categoryList.add(category);
            categoryDao.add(category);
        } else {
            for (Category categories : categoryList) {
                if (category.getName().equals(categories.getName())) {
                    throw new Exception("Category is already exists.");
                }
            }
            categoryList.add(category);
            categoryDao.add(category);
        }

        for (ILogger logger : loggers) {
            logger.log(category.getName());
        }
        System.out.println("/---------------------------------------------/");

    }
}
