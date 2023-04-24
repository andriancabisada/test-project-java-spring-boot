@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
 
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
    }
 
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
 
    public void updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
        existingCategory.setName(category.getName());
        categoryRepository.save(existingCategory);
    }
 
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}