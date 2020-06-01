package com.example.projectname.controller;

import com.example.projectname.exception.ResourceNotFoundException;
import com.example.projectname.model.Item;
import com.example.projectname.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brian_api/v1")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    //  get all item
    @GetMapping("/item")
    public List<Item> getAllItems(Model model) {
        return this.itemRepository.findAll();
    }



//  get all items by id

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long itemId)
            throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + itemId));
        return ResponseEntity.ok().body(item);
    }

//  save item

    @PostMapping("/item")
    public Item createItem(@Valid @RequestBody Item item) {
        return itemRepository.save(item);
    }
//  Update Item

    @PutMapping("/item/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long itemId,
                                                   @Valid @RequestBody Item itemDetails)
            throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(()-> new ResourceNotFoundException("Item not found for this id :: " + itemId));



        item.setItemName(itemDetails.getItemName());
        item.setItemPrice(itemDetails.getItemPrice());


        final Item updatedItem = itemRepository.save(item);


        return ResponseEntity.ok(updatedItem);

    }

//  Delete Employee

    @DeleteMapping("/item/{id}")
    public Map<String, Boolean> deletedItem(@PathVariable(value = "id") Long itemId)
            throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: " + itemId));

        itemRepository.delete(item);
        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted employee", Boolean.TRUE);

        return response;

    }

}

