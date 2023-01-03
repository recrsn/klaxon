export type PagesInfo = Readonly<{
  title?: string;
  icon?: string;
}>;

export type PagesInfoMap = Readonly<Record<string, PagesInfo | undefined>>;
export type RequiredPagesInfoMap = Readonly<Record<string, Required<PagesInfo>>>;

const pages: PagesInfoMap = {
  '/': { icon: 'las la-home', title: 'Home' },
  '/alerts': { icon: 'las la-bell', title: 'Alerts' },
  '/events': { icon: 'las la-stream', title: 'Events' },
  '/environments': { icon: 'las la-globe', title: 'Environments' },
  '/services': { icon: 'las la-server', title: 'Services' },
  '/about': { icon: 'la la-info-circle', title: 'About' },
};

export default pages;
