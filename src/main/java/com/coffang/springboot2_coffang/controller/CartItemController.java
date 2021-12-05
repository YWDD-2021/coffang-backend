import com.coffang.springboot2_coffang.dto.CartItemResponseDto;
import com.coffang.springboot2_coffang.dto.CartItemSaveRequestDto;
import com.coffang.springboot2_coffang.dto.CartItemUpdateRequestDto;
import com.coffang.springboot2_coffang.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CartItemController{
    private final CartItemService cartItemService;

    @PostMapping("/api/v1/cartItems")
    public Long save(@RequestBody CartItemSaveRequestDto requestDto) {
        return cartItemService.save(requestDto);
    }

    @PutMapping("/api/v1/cartItems/{id}")
    public Long update(@PathVariable Long id, @RequestBody CartItemUpdateRequestDto requestDto) {
        return cartItemService.update(id, requestDto);
    }

    @GetMapping("/api/v1/cartItems/{id}")
    public CartItemResponseDto findById(@PathVariable Long id) {
        return cartItemService.findById(id);
    }

    @DeleteMapping("/api/v1/cartItems/{id}")
    public Long delete(@PathVariable Long id) {
        cartItemService.delete(id);
        return id;
    }
}
