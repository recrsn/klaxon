import { AppLayout } from '@hilla/react-components/AppLayout.js';
import { DrawerToggle } from '@hilla/react-components/DrawerToggle.js';
import { Item } from '@hilla/react-components/Item.js';
import { Scroller } from '@hilla/react-components/Scroller.js';
import { NavLink, Outlet, useLocation } from 'react-router-dom';
import css from './MainLayout.module.css';
import pages, { RequiredPagesInfoMap } from './pages';

export default function MenuOnLeftLayout() {
  const { pathname } = useLocation();
  const currentTitle = pages[pathname]?.title ?? 'Unknown';

  return (
    <AppLayout className="block h-full" primarySection="drawer">
      <header slot="drawer">
        <span className="las la-2x la-bullhorn mr-s"></span>
        <h1 className="text-l m-0">Klaxon</h1>
      </header>
      <Scroller slot="drawer" scroll-direction="vertical">
        <nav>
          {Object.entries(pages as RequiredPagesInfoMap).map(([path, { icon: pageIcon, title: pageTitle }]) => (
            <Item key={path}>
              <NavLink className={css.navlink} key={path} to={path}>
                <span className={`${pageIcon} nav-item-icon mx-s`} slot="prefix" aria-hidden="true"></span>
                {pageTitle}
              </NavLink>
            </Item>
          ))}
        </nav>
      </Scroller>
      <footer slot="drawer" />

      <DrawerToggle slot="navbar" aria-label="Menu toggle"></DrawerToggle>
      <h2 slot="navbar" className="text-l m-0">
        {currentTitle}
      </h2>

      <Outlet />
    </AppLayout>
  );
}
