package com.nocpah.kwik.rulesapi.unit.application;

import com.nocpah.kwik.rulesapi.application.usecase.create_menu_item.CreateMenuItemPresenter;
import com.nocpah.kwik.rulesapi.application.usecase.create_menu_item.CreateMenuItemUseCaseImpl;
import com.nocpah.kwik.rulesapi.domain.entity.MenuItem;
import com.nocpah.kwik.rulesapi.domain.repository.MenuItemRepository;
import com.nocpah.kwik.rulesapi.fixture.MenuItemFixture;
import com.nocpah.kwik.rulesapi.fixture.input.CreateMenuItemInputFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateMenuItemUseCaseTest {
    @InjectMocks
    CreateMenuItemUseCaseImpl useCase;
    @Mock
    CreateMenuItemPresenter presenter;
    @Mock
    MenuItemRepository menuItemRepository;

    @Test
    void shouldSaveMenuItem() {
        var input = CreateMenuItemInputFixture.caeserSalad();
        var expectedMenuItem = MenuItemFixture.caesarSalad();

        useCase.execute(input, presenter);

        var captor = ArgumentCaptor.forClass(MenuItem.class);
        Mockito.verify(menuItemRepository).save(captor.capture());
        Assertions.assertThat(captor.getValue())
                .usingRecursiveComparison()
                .ignoringFields("code", "canBeSold")
                .isEqualTo(expectedMenuItem);
        Assertions.assertThat(captor.getValue().isCanBeSold()).isFalse();
    }
}
