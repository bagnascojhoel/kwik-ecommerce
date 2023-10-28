package com.nocpah.kwik.rulesapi.application.usecase.create_menu_item;

import com.nocpah.kwik.rulesapi.domain.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateMenuItemUseCaseImpl implements CreateMenuItemUseCase {
    private final MenuItemRepository menuItemRepository;

    @Override
    public void execute(CreateMenuItemInput input, CreateMenuItemPresenter presenter) {
        var menuItem = CreateMenuItemFactory.create(input);
        menuItemRepository.save(menuItem);
        presenter.onSuccess();
    }
}
