import { Kozlovsky.AntonPage } from './app.po';

describe('kozlovsky.anton App', () => {
  let page: Kozlovsky.AntonPage;

  beforeEach(() => {
    page = new Kozlovsky.AntonPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
