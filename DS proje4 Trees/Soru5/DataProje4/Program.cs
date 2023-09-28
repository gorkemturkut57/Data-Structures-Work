using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataProje4
{
    public class TrieNode
    {
        public char Value { get; set; }
        public TrieNode[] Children { get; set; }
        public bool IsEndOfWord { get; set; }

        public TrieNode(char value)
        {
            Value = value;
            Children = new TrieNode[26];
            IsEndOfWord = false;
        }
    }

    public class Trie
    {
        private TrieNode _root;

        public Trie()
        {
            _root = new TrieNode(' ');
        }

        public void Insert(string word)
        {
            var currentNode = _root;

            foreach (var c in word)
            {
                var childIndex = c - 'a';
                if (currentNode.Children[childIndex] == null)
                {
                    currentNode.Children[childIndex] = new TrieNode(c);
                }
                currentNode = currentNode.Children[childIndex];
            }

            currentNode.IsEndOfWord = true;
        }

        public bool Search(string word)
        {
            var currentNode = _root;

            foreach (var c in word)
            {
                var childIndex = c - 'a';
                if (currentNode.Children[childIndex] == null)
                {
                    return false;
                }
                currentNode = currentNode.Children[childIndex];
            }

            return currentNode.IsEndOfWord;
        }
    }

    internal class Program
    {
        static void Main(string[] args)
        {
            //Trie yaratma
            Trie trie = new Trie();

            //Eleman insert etme
            trie.Insert("Selam");
            trie.Insert("Dunya");
            trie.Insert("Merhaba");

        }
    }
}
